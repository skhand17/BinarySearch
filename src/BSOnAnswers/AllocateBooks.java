package BSOnAnswers;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] books = new int[] {25, 46, 28, 49, 24};
        int numStudents = 4;

        int ans = allocateBook(books, numStudents);
        System.out.println(ans);
    }

    public static int allocateBook(int[] books, int numStudents) {

        int maxEle = Integer.MIN_VALUE;
        int totalSum = 0;

        for(int i=0; i<books.length; i++){
            maxEle = Math.max(maxEle, books[i]);
            totalSum += maxEle;
        }

        int low = maxEle;
        int high = totalSum;

        while (low <= high) {
            int mid = (low + high) / 2;

            int totalNumStudents = countTotalNoStudents(books, mid);
            if(totalNumStudents > numStudents){
                low = mid + 1;
            } else if (totalNumStudents <= numStudents){
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countTotalNoStudents(int[] books, int pages) {
        int students = 1;
        int pagesWithStudent = 0;

        for(int i=0; i<books.length; i++){

            if(pagesWithStudent + books[i] <= pages){
                pagesWithStudent += books[i];
            } else {
                students++;
                pagesWithStudent = books[i];
            }
        }
        return students;
    }
}
