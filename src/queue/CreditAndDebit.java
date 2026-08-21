package queue;

public class CreditAndDebit {

    private static int sum(LinkedQueue q){
        int sum = 0;

        //first we are setting temp as first element of the queue it will
        // run until it reaches head again
        for(LinkedQueue.Node temp = q.head.next; temp != q.head; temp = temp.next){
            sum += (int) temp.data;
        }

        return sum;
    }


    public static void main(String[] args) {
        LinkedQueue credit = new LinkedQueue();
        LinkedQueue debit = new LinkedQueue();

        //CREDITS
        credit.add(200);
        credit.add(400);
        credit.add(100);
        credit.add(1500);

        //DEBIT
        debit.add(100);
        debit.add(200);
        debit.add(400);
        debit.add(250);

        //SUM
        int totalCredit = sum(credit);
        int totalDebit = sum(debit);

        int remaining = totalCredit - totalDebit;

        System.out.println("Total Credit: " + totalCredit);
        System.out.println("Total Debit: " + totalDebit);
        System.out.println("Remaining: " + remaining);


    }
}
