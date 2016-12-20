package wasteDisposal.processData.dataBase;

import wasteDisposal.processData.ProcessingData;

import java.util.ArrayList;
import java.util.List;

public class ConcreteProcessDataBase implements ProcessDataBase {

    private List<ProcessingData> processingDatas;

    public ConcreteProcessDataBase() {
        this.setProcessingDatas(new ArrayList<>());
    }

    public List<ProcessingData> getProcessingDatas() {
        return this.processingDatas;
    }

    private void setProcessingDatas(List<ProcessingData> processingDatas) {
        this.processingDatas = processingDatas;
    }
}
