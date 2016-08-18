package chainOfResponsibiltyDemo;

import chainOfResponsibiltyDemo.models.BankEmployee;
import chainOfResponsibiltyDemo.models.Clerk;
import chainOfResponsibiltyDemo.models.LoanRequest;
import chainOfResponsibiltyDemo.models.LocalManager;

public class Main {
    public static void main(String[] args) {

        BankEmployee clerk = new Clerk();
        BankEmployee manager = new LocalManager();

        LoanRequest loanRequest = new LoanRequest(18000, "Study");

        clerk.setSuccessor(manager);
        clerk.processRequest(loanRequest);
    }
}
