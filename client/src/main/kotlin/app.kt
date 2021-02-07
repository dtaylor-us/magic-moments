import kotlinx.html.UL
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

external interface AppProps : RProps {
    var name: String
}

data class AppState(val name: String) : RState

@JsExport
class App(props: AppProps) : RComponent<AppProps, AppState>(props) {

    init {
        state = AppState(props.name)
    }

    override fun RBuilder.render() {


        header {
            div(classes = "cover bg-left bg-center-l") {
                style(type = "background-image: url(http://mrmrs.github.io/photos/u/011.jpg)") {}
                div(classes = "bg-black-80 pb5 pb6-m pb7-l") {
                    nav(classes = "dt w-100 mw8 center") {
                        div(classes = "dtc v-mid pa3") {
                            a(href = "/") {
                                img(src = "img/profile_circle.png", classes = "w3 h3 mr3 br-100 pa1 ba bw1 b--white") {}
                            }
                        }
                        div(classes = "dtc v-mid tr pa3") {
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-ns pv2 ph3") {+"How it Works"}
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-ns pv2 ph3") {+"Pricing"}
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-l pv2 ph3") {+"About"}
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-l pv2 ph3") {+"Careers"}
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dib ml2 pv2 ph3 ba") {+"Sign Up"}
                        }
                    }
                    div(classes = "tc-l mt4 mt5-m mt6-l ph3") {
                        h1(classes = "f2 f1-l fw2 white-90 mb0 lh-title"){
                            +"This is your super impressive headline"
                        }
                        h2(classes = "fw1 f3 white-80 mt3 mb4") {
                            +"Now a subheadline where explain your wonderful new startup even more"
                        }
                        a(href = "/", classes = "f6 no-underline grow dib v-mid bg-blue white ba b--blue ph3 pv2 mb3") {
                            +"Call to Action"
                        }
                        span(classes = "dib v-mid ph3 white-70 mb3") { +"or" }
                        a(href = "/", classes = "f6 no-underline grow dib v-mid white ba b--white ph3 pv2 mb3") { +"Secondary call to action"}
                    }
                }
            }
        }
//        navbar {
//            attrs.bg = "dark"
//            attrs.className = "white"
//            attrs.variant = "dark"
//            navbarBrand {
//                img(src = "img/profile_circle.png", classes = "w3 h3 mr3 br-100 pa1 ba bw1 b--white") {}
//            }
//            div(classes = "w-75") {
//                ul(classes = "navbar-nav") {
//                    navItem("#", "Software Engineering")
//                    navItem("#", "Visual Design")
//                    navItem("#", "Mindset")
//                }
//                span(classes = "bi bi-alt") {}
//
//            }
//
//
//        }
//
//        article(classes = "pa3 ph5-ns") {
//            h3(classes = "f6 ttu tracked mt0") {
//                +"Leslie is a POOP"
//            }
//            p(classes = "f4 lh-copy") {
//                +"There is a base border module that can be extended with the border-width, border-color, border-style modules. By default you don’t need to set a border color. It will just inherit whatever the text color is for that dom node. You can target any side to put a border on ie. top, right, bottom, left."
//            }
//        }
    }

    private fun RDOMBuilder<UL>.navItem(url: String, text: String) {
        li(classes = "nav-item") {
            a(classes = "nav-link", href = url) {
                +text
            }
        }
    }
}
