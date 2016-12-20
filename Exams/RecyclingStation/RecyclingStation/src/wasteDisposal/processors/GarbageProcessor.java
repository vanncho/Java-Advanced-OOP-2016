package wasteDisposal.processors;

import wasteDisposal.waste.Waste;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.strategies.holders.StrategyHolder;

/**
 * Interface that exposes the framework's Garbage Processor's members.
 */
public interface GarbageProcessor {

    /**
     * A getter method for the StrategyHolder object, holding the currently contained strategies.
     * @return
     */
    StrategyHolder getStrategyHolder();

    /**
     * Processes an object of Waste type, using reflection to find an appropriate strategy based on the passed in object's annotations.
     * The reflection takes the first annotation that contains the meta-annotation Disposal Annotation, which is exposed by the framework
     * and maps an appropriate strategy based on it.
     *
     * <p>This method delegates the actual processData to an underlying Garbage Disposal Strategy object.
     *
     * @param garbage The Waste object that will be processed.
     * @return An object of type ProcessingData containing all information about the results of the processData.
     */
    ProcessingData processWaste(Waste garbage);
}
