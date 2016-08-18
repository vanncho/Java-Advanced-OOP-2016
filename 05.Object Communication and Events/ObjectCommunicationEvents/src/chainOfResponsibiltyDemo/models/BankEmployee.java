package chainOfResponsibiltyDemo.models;

import chainOfResponsibiltyDemo.interfaces.Employee;

public abstract class BankEmployee implements Employee {

    private Employee successor;

    abstract String getRole();
    abstract int getAllowable();

    @Override
    public void setSuccessor(Employee successor) {
        this.successor = successor;
    }

    @Override
    public void processRequest(LoanRequest request) {

        if (request.getAmount() <= this.getAllowable()) {
            System.out.println(this.getRole() + " approved the request!");
        } else if (this.successor != null) {
            this.successor.processRequest(request);
        }
    }
}
