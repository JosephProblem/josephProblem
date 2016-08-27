

class CommandLineUtilityParsingSpec  extends org.specs2.mutable.Specification {


  "Invalid parameter specification" >> {

    "Exception is thrown when less than 2 parameters" >> {
      val ints: Array[String] = Array("notAnInt", "2")
      CommandLineParametersParsingUtility.extractParameters(ints) must throwA[IllegalArgumentException]
    }
    "Exception is thrown when more than 2 parameters" >> {
      val ints: Array[String] = Array("1", "notAnInt", "d")
      CommandLineParametersParsingUtility.extractParameters(ints) must throwA[IllegalArgumentException]
    }

    "Exception is thrown when the first parameter is not an int" >> {
      val ints: Array[String] = Array("notAnInt", "2")
      CommandLineParametersParsingUtility.extractParameters(ints) must throwA[IllegalArgumentException](message = ACountingProblem.NUMBER_OF_PPL_IN_CIRCLE)
    }
    "Exception is thrown when the second parameter is not an int" >> {
      val ints: Array[String] = Array("1", "notAnInt")
      CommandLineParametersParsingUtility.extractParameters(ints) must throwA[IllegalArgumentException](message = ACountingProblem.STEP_COUNT)
    }

    "Exception is thrown when the first parameter is zero" >> {
      val ints: Array[String] = Array("0", "1")
      CommandLineParametersParsingUtility.extractParameters(ints) must throwA[IllegalArgumentException](message = ACountingProblem.NUMBER_OF_PPL_IN_CIRCLE)
    }

  }

  "valid parameter specification" >> {
    "returns correctly parsed ints" >> {
      val ints: Array[String] = Array("4", "6")
      CommandLineParametersParsingUtility.extractParameters(ints) must_==(4, 6)
    }
  }
}