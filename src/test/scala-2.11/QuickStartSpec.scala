import java.lang.IllegalArgumentException

import org.specs2._

class ACountingProblemSpec  extends org.specs2.mutable.Specification {

  "mandatory tests" >> {

    "n == k" >> {
      ACountingProblem.findBestSpotToStand(5,5) must_== 2
    }

    "n = 3 and k = 2" >> {
      ACountingProblem.findBestSpotToStand(3,2) must_== 3
    }

    "n is very large, but k =2" >> {
      ACountingProblem.findBestSpotToStand(100000,2) must_== 68929
    }

  }

  "single person test cases" >> {

    "person 1 survives when there is only a single person in the circle" >> {
      ACountingProblem.findBestSpotToStand(1, 1) must_== 1
    }

    "person 1 survives when there is only a single person for any k" >> {
      val r = scala.util.Random
      ACountingProblem.findBestSpotToStand(1, r.nextInt(10000)) must_== 1
    }
  }

  "more complex scenarios" >> {
    // these have been validated using http://webspace.ship.edu/deensley/mathdl/Joseph.html
    "person 2 survives under scenrio x " >> {
      ACountingProblem.findBestSpotToStand(2, 1) must_== 2
    }

    "last person in list survives when step count is 1" >> {
      ACountingProblem.findBestSpotToStand(10,1) must_== 10
    }

    "works when step count is larger than the number of people in the circle" >> {
      ACountingProblem.findBestSpotToStand(100, 543) must_== 24
    }

    "person 31 survives" >> {
      ACountingProblem.findBestSpotToStand(41, 3) must_== 31
    }

    "person 21 survives" >> {
      ACountingProblem.findBestSpotToStand(41, 5) must_== 21
    }

  }
}