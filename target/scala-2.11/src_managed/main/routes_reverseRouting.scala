// @SOURCE:/home/juan/web/torneo/conf/routes
// @HASH:7e5123ce9d387368f358fcdb6b50fb8dc04e223f
// @DATE:Sat Sep 06 14:59:38 ART 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:10
// @LINE:7
// @LINE:6
// @LINE:5
package controllers {

// @LINE:10
class ReverseAssets {


// @LINE:10
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:7
// @LINE:6
// @LINE:5
class ReverseApplication {


// @LINE:6
def obtenerJugadores(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "jugadores")
}
                        

// @LINE:5
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:7
def detallesJugador(nombre:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "jugadores/" + implicitly[PathBindable[String]].unbind("nombre", dynamicString(nombre)))
}
                        

}
                          
}
                  


// @LINE:10
// @LINE:7
// @LINE:6
// @LINE:5
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:10
class ReverseAssets {


// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:7
// @LINE:6
// @LINE:5
class ReverseApplication {


// @LINE:6
def obtenerJugadores : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.obtenerJugadores",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jugadores"})
      }
   """
)
                        

// @LINE:5
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def detallesJugador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.detallesJugador",
   """
      function(nombre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jugadores/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nombre", encodeURIComponent(nombre))})
      }
   """
)
                        

}
              
}
        


// @LINE:10
// @LINE:7
// @LINE:6
// @LINE:5
package controllers.ref {


// @LINE:10
class ReverseAssets {


// @LINE:10
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:7
// @LINE:6
// @LINE:5
class ReverseApplication {


// @LINE:6
def obtenerJugadores(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.obtenerJugadores(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "obtenerJugadores", Seq(), "GET", """""", _prefix + """jugadores""")
)
                      

// @LINE:5
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home Page""", _prefix + """""")
)
                      

// @LINE:7
def detallesJugador(nombre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.detallesJugador(nombre), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "detallesJugador", Seq(classOf[String]), "GET", """""", _prefix + """jugadores/$nombre<[^/]+>""")
)
                      

}
                          
}
        
    