package com.realityprogrammer.bigexercise;

public class ApplicationData {
    private static final StudentLinkedList studentList = new StudentLinkedList();

    static {
        studentList.addLast(new Student("0001", "Nguyễn Ngọc Huy Hoàng", 9));
        studentList.addLast(new Student("0002", "Nguyễn Đức Dân", 8));
        studentList.addLast(new Student("0003", "Hoàng Minh Thành", 9));
        studentList.addLast(new Student("0004", "Lê Công Thành", 7));
        studentList.addLast(new Student("0005", "Trần Hoàng Nam", 7.5));
        studentList.addLast(new Student("0006", "Đinh Văn Thắng", 6.5));
        studentList.addLast(new Student("0007", "Nguyễn Mạnh Dũng", 7.5));
        studentList.addLast(new Student("0008", "Hoàng Việt Anh", 6.25));
        studentList.addLast(new Student("0009", "Lê Thị Kim Duyên", 7.25));
        studentList.addLast(new Student("0010", "Nguyễn Huy Cường", 5.75));
        studentList.addLast(new Student("0011", "Phạm Văn Hải", 8.25));
        studentList.addLast(new Student("0012", "Tạ Việt Anh", 6.75));
        studentList.addLast(new Student("0013", "Trần Thị Linh Phương", 9.25));
        studentList.addLast(new Student("0014", "Trần Văn Huy", 5.25));
        studentList.addLast(new Student("0015", "Phạm Phương Thảo", 6));
        studentList.addLast(new Student("0016", "Bùi Quang Anh", 8));
        studentList.addLast(new Student("0017", "Đàm Văn Hòa", 5));
        studentList.addLast(new Student("0018", "Nguyễn Mạnh Cường", 8));
        studentList.addLast(new Student("0019", "Vũ Văn Trường", 7.75));
        studentList.addLast(new Student("0020", "Nguyễn Văn Trường", 9.25));
        studentList.addLast(new Student("0021", "Nguyễn Viết Hoàng Anh", 8.25));
        studentList.addLast(new Student("0022", "Vũ Hải Khánh", 4.25));
        studentList.addLast(new Student("0023", "Nguyễn Tiến Thành", 7.25));
        studentList.addLast(new Student("0024", "Vũ Minh Hiếu", 7.75));
        studentList.addLast(new Student("0025", "Khuất Trọng Hiếu", 8));
        studentList.addLast(new Student("0026", "Hà Đức Thành", 4));
    }

    public static StudentLinkedList getStudentList() {
        return studentList;
    }
}
