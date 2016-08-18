package chainOfResponsibiltyDemo.interfaces;

import chainOfResponsibiltyDemo.models.LoanRequest;

public interface Employee {

    void setSuccessor(Employee successor);

    void processRequest(LoanRequest request);
}
