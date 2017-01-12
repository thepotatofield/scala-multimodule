package modules

import com.google.inject.AbstractModule
import dev.nico.Dummy
import play.api.{Configuration, Environment}

/**
  * Created by nicolasaubry on 18/04/16.
  */
class DummyModule(env: Environment,
                  conf: Configuration) extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[Dummy])
  }
}
