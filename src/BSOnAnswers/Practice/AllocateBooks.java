package BSOnAnswers.Practice;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] books = new int[] {25, 46, 28, 49, 24};
        int numStudents = 4;

        int maxPageIsMin = MaxPagesIsMinimum(books, numStudents);
        System.out.println(maxPageIsMin);
    }

    public static int MaxPagesIsMinimum(int[] books, int numStudents) {

        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int i=0; i<books.length; i++) {
            low = Math.min(low, books[i]);
            high += books[i];
        }

        while (low <= high) {

            int mid = (low + high)/2;
            int totalStudents = pagesAllocatedStudents(books, mid);
            if(totalStudents > numStudents){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static int pagesAllocatedStudents(int[] books, int maxPage) {
        int numStudent = 1;
        int pagesWithinStudent = 0;

        for(int i=0; i<books.length; i++) {
            if(pagesWithinStudent + books[i] <= maxPage){
                pagesWithinStudent += books[i];
            } else {
                numStudent++;
                pagesWithinStudent = books[i];
            }
        }
        return numStudent;
    }
}
