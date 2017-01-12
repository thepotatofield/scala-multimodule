package controllers

import javax.inject.{Inject, Singleton}

import dev.nico.Dummy
import play.api.mvc.{Action, Controller}

/**
  * Created by nicolasaubry on 18/04/16.
  */
@Singleton
class DummyController @Inject()(dummy: Dummy) extends Controller {

  def saySomething() = Action {
    Ok(dummy.cantEvenSayHello())
  }

}
