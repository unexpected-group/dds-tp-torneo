
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.17*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html ng-app="app">
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css")),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png")),format.raw/*9.97*/("""">
        <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.15/angular.min.js"></script>
        <script src=""""),_display_(/*11.23*/routes/*11.29*/.Assets.at("javascripts/app.js")),format.raw/*11.61*/("""" type="text/javascript"></script>
    </head>
    <body ng-controller="DetallesController as dc">
        <h2>Jugadores Inscriptos</h2>
        Filtro: <input ng-model="search">
        <ul ng-controller="JugadoresController as jc">
	        <div ng-repeat="jugador in jc.jugadores | filter: search | orderBy:'-edad'">
	        	<li>
		        	<p><a href="/jugadores/"""),format.raw/*19.35*/("""{"""),format.raw/*19.36*/("""{"""),format.raw/*19.37*/("""jugador.nombre"""),format.raw/*19.51*/("""}"""),format.raw/*19.52*/("""}"""),format.raw/*19.53*/("""">"""),format.raw/*19.55*/("""{"""),format.raw/*19.56*/("""{"""),format.raw/*19.57*/("""jugador.nombre"""),format.raw/*19.71*/("""}"""),format.raw/*19.72*/("""}"""),format.raw/*19.73*/("""</a> - """),format.raw/*19.80*/("""{"""),format.raw/*19.81*/("""{"""),format.raw/*19.82*/("""jugador.edad"""),format.raw/*19.94*/("""}"""),format.raw/*19.95*/("""}"""),format.raw/*19.96*/("""</p>
	        		<button ng-click="dc.activar(jugador.nombre)">Mas Informacion</button>
	        	</li>
	        </div>
        </ul>
        <hr/>
    	<p ng-show="dc.estaActivado()">"""),format.raw/*25.37*/("""{"""),format.raw/*25.38*/("""{"""),format.raw/*25.39*/("""dc.nombre"""),format.raw/*25.48*/("""}"""),format.raw/*25.49*/("""}"""),format.raw/*25.50*/("""</p>
    	<button ng-click="dc.desactivar()">Ocultar Informacion</button>
    	<div ng-controller="JugadorController as jc">
	        <p>Nombre: """),format.raw/*28.21*/("""{"""),format.raw/*28.22*/("""{"""),format.raw/*28.23*/("""jc.jugador.nombre"""),format.raw/*28.40*/("""}"""),format.raw/*28.41*/("""}"""),format.raw/*28.42*/("""</p>
	        <p>Edad: """),format.raw/*29.19*/("""{"""),format.raw/*29.20*/("""{"""),format.raw/*29.21*/("""jc.jugador.edad"""),format.raw/*29.36*/("""}"""),format.raw/*29.37*/("""}"""),format.raw/*29.38*/("""</p>
    	</div>
    </body>
</html>"""))}
  }

  def render(title:String): play.twirl.api.HtmlFormat.Appendable = apply(title)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (title) => apply(title)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Sep 06 18:14:47 ART 2014
                  SOURCE: /home/juan/web/torneo/app/views/index.scala.html
                  HASH: a03425c68a2511a7cd13dace4235239da6b24116
                  MATRIX: 723->1|826->16|854->18|944->82|969->87|1057->149|1071->155|1125->189|1212->250|1226->256|1278->288|1428->411|1443->417|1496->449|1893->818|1922->819|1951->820|1993->834|2022->835|2051->836|2081->838|2110->839|2139->840|2181->854|2210->855|2239->856|2274->863|2303->864|2332->865|2372->877|2401->878|2430->879|2641->1062|2670->1063|2699->1064|2736->1073|2765->1074|2794->1075|2967->1220|2996->1221|3025->1222|3070->1239|3099->1240|3128->1241|3179->1264|3208->1265|3237->1266|3280->1281|3309->1282|3338->1283
                  LINES: 26->1|29->1|31->3|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|53->25|53->25|53->25|53->25|53->25|53->25|56->28|56->28|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|57->29|57->29
                  -- GENERATED --
              */
          