import scala.math.BigInt

/**
  * Responsible for parsing and validating the command line parameters are correct.
  */

object CommandLineParametersParsingUtility {

  def extractParameters(args: Array[String]): (BigInt, BigInt) = {
    require(args.length == 2, "Exactly 2 command line parameters must be passed in.")
    val numberOfPeopleInCircle: BigInt = readCommandLineParameter(args {0}, ACountingProblem.NUMBER_OF_PPL_IN_CIRCLE)
    val stepCount: BigInt = readCommandLineParameter(args {1}, ACountingProblem.STEP_COUNT)
    (numberOfPeopleInCircle, stepCount)
  }

  private def readCommandLineParameter(arg :String,label :String): BigInt = {
    try {
      val commandLineParameter: BigInt = BigInt(arg)
      require(commandLineParameter>0, label + " must be positive")
      commandLineParameter
    } catch {
      case exception : NumberFormatException =>
        throw new IllegalArgumentException("Failed to convert the parameter " +
          "\""+label+"\" to integer. " + arg
          + " is not a valid int.");
    }
  }
}
