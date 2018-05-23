package com.learningakka

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class AkkaDbTest extends FunSpecLike with Matchers with BeforeAndAfterEach {

  implicit val system = ActorSystem()

  describe("akkademyDb") {

    describe("given SetRequest") {

      it("should place key/value into map") {

        val actorRef = TestActorRef(new AkkaDb)
        actorRef ! SetRequest("key", "value")
        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }
  }
}
