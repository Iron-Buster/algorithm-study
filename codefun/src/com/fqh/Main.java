package com.fqh;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    /**
     * 算法目的：每个课程都有（0~N-1）个先修课程，算法需要找到一个合法的修课顺序。（可能存在多个）
     * 数据输入方式：支持终端输入和文件输入
     * 将所有合法的方案输出到文件
     */


    /**
     * 拓扑排序
     * 在一个 DAG（有向无环图） 中，我们将图中的顶点以线性方式进行排序，使得对于任何的顶点 u 到 v 的有向边 (u,v), 都可以有 u 在 v 的前面。
     * 还有给定一个 DAG，如果从 i 到 j 有边，则认为 j 依赖于 i。如果 i 到 j 有路径（i 可达 j），则称 j 间接依赖于 i。
     * 拓扑排序的目标是将所有节点排序，使得排在前面的节点不能依赖于排在后面的节点。
     *
     * 时间复杂度：O(N + M)
     * 空间复杂度：O(N + M)
     * N 和 M分别是 课程数和边数
     *
     */
    public static void topoSort(List<Course> courseList) {
        // 0.建图
        buildGraph(courseList);
        Deque<String> deque = new ArrayDeque<>();
        // 1.从图中选择一个入度为零的点。
        for (Course course : courseList) {
            if (inDegree.getOrDefault(course.getNumber(), 0) == 0) { // 入度为0的入队
                deque.offer(course.getNumber());
            }
        }
        List<String> result = new ArrayList<>();
        int n = courseList.size();

        while (!deque.isEmpty()) {
            String u = deque.poll();
            --n;
            result.add(u);
            // 2.输出该顶点，从图中删除此顶点及其所有的出边。
            for (String v : graph.getOrDefault(u, new ArrayList<>())) {
                inDegree.merge(v, -1, Integer::sum); // 入度 - 1
                if (inDegree.get(v) == 0) {
                    deque.offer(v);
                }
            }
        }
        // 重复上面两步，直到所有顶点都输出，拓扑排序完成，或者图中不存在入度为零的点，此时说明图是有环图，拓扑排序无法完成，陷入死锁。
        if (n != 0) { // 课程存在循环依赖关系，无法修完所有课程
            throw new RuntimeException("课程存在循环依赖关系，无法修完所有课程");
        }

//        Map<String, Course> map = courseList.stream().collect(Collectors.toMap(k -> k.getNumber(), v -> v));
//        List<String> result2 = new ArrayList<>();
//
//        for (String number : result) {
//            Course course = map.get(number);
//            result2.add(course.toString());
//        }
        // 保存结果到文件
//        if (SAVE_RESULT_TO_FILE) {
//            writeToFile(result2, "output.txt");
//        }
    }

    /**
     * 建有向图(DAG)的方法
     * @param courseList 课程列表
     */
    public static void buildGraph(List<Course> courseList) {
        inDegree = new HashMap<>();
        graph = new HashMap<>();
        for (Course course : courseList) {
            String a = course.getNumber();
            List<String> coursePre = course.getPre();
            if (coursePre.size() == 1 && coursePre.get(0).equals("-1")) continue; // -1表示没有先修课程

            for (String b : coursePre) {
                inDegree.merge(a, 1, Integer::sum); // 入度 + 1
                // b -> a 的一条有向边
                graph.computeIfAbsent(b, e -> new ArrayList<>());
                graph.get(b).add(a);
            }
        }
    }


    /**
     * 回溯 搜索出所有的合法拓扑序方案
     * @param now
     * @param k 课程数量
     * @param inDegree 记录节点入度
     * @param graph    有向图
     * @param path     结果路径
     */
    public static void dfs(int now, int k, List<Course> courseList, Map<String, Integer> inDegree, Map<String, List<String>> graph, List<String> path) {
        if (now == k) {
            out.println(path);
            return;
        }
        for (int i = 0; i < courseList.size(); i++) {
            Course cur = courseList.get(i);
            if (inDegree.getOrDefault(cur.number, 0) == 0 && !mark.contains(cur.number)) {
                path.add(cur.number);
                mark.add(cur.number);
                for (String next : graph.getOrDefault(cur.number, new ArrayList<>())) {
                    inDegree.merge(next, -1, Integer::sum); // 全部入度 - 1
                }

                dfs(now + 1, k, courseList, inDegree, graph, path);

                // 恢复现场
                path.remove(path.size() - 1);
                mark.remove(cur.number);
                for (String next : graph.getOrDefault(cur.number, new ArrayList<>())) {
                    inDegree.merge(next, 1, Integer::sum); // 全部入度 + 1
                }
            }
        }
    }

    static Map<String, List<String>> graph = new HashMap<>(); // 邻接表存图
    static Map<String, Integer> inDegree = new HashMap<>(); // 记录每个节点的入度
    static Set<String> mark = new HashSet<>(); // 标记是否访问
    static int n; // 学期总数
    static int m; // 一学期学分上限
    static int k; // 课程数
    static List<Course> courseList; // 课程列表



    /**
     * 将结果写入文件的方法
     * @param strings   需要写入的结果
     * @param filePath  文件路径
     */
    public static void writeToFile(List<String> strings, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            int index = 0;
            for (String str : strings) {
                writer.write(++index + " "  + str);
                writer.newLine(); // To add a new line after each string
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件读取数据
     * @param filePath
     */
    public static void readFormFile(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        n = Integer.parseInt(list.get(0));
        m = Integer.parseInt(list.get(1));
        k = Integer.parseInt(list.get(2));
        courseList = new ArrayList<>();
        for (int i = 3; i < list.size(); i++) {
            String s = list.get(i);
            String[] split = s.split(" ");

            Course course = new Course();
            course.setNumber(split[0]);
            course.setScore(split[1]);

            String[] preCourse = split[2].split(";");
            List<String> list1 = Arrays.stream(preCourse).collect(Collectors.toList());
            course.setPre(list1);  // -1表示没有先修课程
            courseList.add(course);
        }

    }


    //    输入参数包括学期总数、一学期的学分上限、每门课程的课程号、学分和直接先修课的课程号


    static boolean READ_FORM_FILE = false; // 是否从终端读取输入数据
    static boolean SAVE_RESULT_TO_FILE = true; // 是否保存结果到文件

    public static void main(String[] args) throws IOException {
        if (READ_FORM_FILE) {
            readFormFile("input.txt");
        } else {
            n = in.nextInt(); // 学期总数
            m = in.nextInt(); // 一学期学分上限
            // 上面两个参数属实不知道有啥用
            k = in.nextInt(); // 输入k个课程

            for (int i = 0; i < k; i++) {
                String s = in.nextLine();
                String[] split = s.split(" ");

                Course course = new Course();
                course.setNumber(split[0]);
                course.setScore(split[1]);

                String[] preCourse = split[2].split(";");
                List<String> list = Arrays.stream(preCourse).collect(Collectors.toList());
                course.setPre(list);  // -1表示没有先修课程
                courseList.add(course);
            }
        }

        // ======================= 拓扑排序 =============================================================================
        topoSort(courseList);

        // ========================= 回溯搜索所有的拓扑序方案 ==============================================================
        buildGraph(courseList);
        dfs(0, k, courseList, inDegree, graph, new ArrayList<>());
        if (SAVE_RESULT_TO_FILE) {

        }
        out.close();
    }


    // =============================================== 课程类 ===========================================================
    static class Course {
        // 课程号
        String number;
        // 学分
        String score;
        // 先修课（存在多门）
        List<String> pre;

        public Course() {}

        public Course(String number, String score, List<String> pre) {
            this.number = number;
            this.score = score;
            this.pre = pre;
        }


        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public List<String> getPre() {
            return pre;
        }

        public void setPre(List<String> pre) {
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "number='" + number + '\'' +
                    ", score='" + score + '\'' +
                    ", pre='" + pre + '\'' +
                    '}';
        }
    }



    // =================================== Java 快速读入模板 =============================================================
    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }


}


