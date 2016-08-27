
import com.google.common.annotations.VisibleForTesting

import scala.math.BigInt

/**
  * The main class of the application.
  * Responsible only for computing the best place to stand in the circle to avoid being killed.
  *
  * All parameters validation and parsing is handled in {@Class CommandLineParametersParsingUtility}
  */
object ACountingProblem {

    val NUMBER_OF_PPL_IN_CIRCLE: String = "Number of people in circle"
    val STEP_COUNT: String = "Step count"

    def main(args: Array[String]): Unit = {
        val (numberOfPeopleInCircle, stepCount) = CommandLineParametersParsingUtility.extractParameters(args)
        println(findBestSpotToStand(numberOfPeopleInCircle,stepCount))
    }

    /** private method that computes the ideal location to stand in the circle to avoid death.
      *
      * WARNING This method treats the first position in the circle as 0, for convince sake.
      * all external systems must call the public method below to get the result in a more human readable format .i.e first position in circle is 1.
      */
    private def findBestSpotToStandInternal(numberOfPeopleInCircle: BigInt,stepCount: BigInt): BigInt = {
        var currentCount : BigInt = 0
        for(i <- BigInt(1) to numberOfPeopleInCircle){
            currentCount = (stepCount+currentCount)%i
        }
        currentCount
    }

    /**
      * Acts as a wrapper around the private method findBestSpotToStandInternal.
      * @returns the ideal place to stand in the circle
      * */
    @VisibleForTesting
    def findBestSpotToStand(numberOfPeopleInCircle: BigInt,stepCount: BigInt): BigInt = {
        findBestSpotToStandInternal(numberOfPeopleInCircle , stepCount) +1
    }


}
