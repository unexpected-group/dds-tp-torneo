// @SOURCE:/home/juan/web/torneo/conf/routes
// @HASH:7e5123ce9d387368f358fcdb6b50fb8dc04e223f
// @DATE:Sat Sep 06 14:59:38 ART 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:5
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home Page""", Routes.prefix + """"""))
        

// @LINE:6
private[this] lazy val controllers_Application_obtenerJugadores1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jugadores"))))
private[this] lazy val controllers_Application_obtenerJugadores1_invoker = createInvoker(
controllers.Application.obtenerJugadores(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "obtenerJugadores", Nil,"GET", """""", Routes.prefix + """jugadores"""))
        

// @LINE:7
private[this] lazy val controllers_Application_detallesJugador2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jugadores/"),DynamicPart("nombre", """[^/]+""",true))))
private[this] lazy val controllers_Application_detallesJugador2_invoker = createInvoker(
controllers.Application.detallesJugador(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "detallesJugador", Seq(classOf[String]),"GET", """""", Routes.prefix + """jugadores/$nombre<[^/]+>"""))
        

// @LINE:10
private[this] lazy val controllers_Assets_at3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at3_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jugadores""","""controllers.Application.obtenerJugadores()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jugadores/$nombre<[^/]+>""","""controllers.Application.detallesJugador(nombre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:5
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:6
case controllers_Application_obtenerJugadores1_route(params) => {
   call { 
        controllers_Application_obtenerJugadores1_invoker.call(controllers.Application.obtenerJugadores())
   }
}
        

// @LINE:7
case controllers_Application_detallesJugador2_route(params) => {
   call(params.fromPath[String]("nombre", None)) { (nombre) =>
        controllers_Application_detallesJugador2_invoker.call(controllers.Application.detallesJugador(nombre))
   }
}
        

// @LINE:10
case controllers_Assets_at3_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at3_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     