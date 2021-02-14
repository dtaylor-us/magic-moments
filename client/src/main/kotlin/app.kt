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

        // HEADER
        header {
            // COVER
            div(classes = "cover") {
                style(type = "background-image: url(http://mrmrs.github.io/photos/u/011.jpg)") {}
                div(classes = "bg-black-80 pb5 pb6-m pb7-l") {
                    // NAVIGATION
                    nav(classes = "dt w-100 mw8 center") {
                        div(classes = "dtc v-mid pa3") {
                            a(href = "/") {
                                img(src = "img/profile_circle.png", classes = "w3 h3 mr3 br-100 pa1 ba bw1 b--white") {}
                            }
                        }
                        div(classes = "dtc v-mid tr pa3") {
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-ns pv2 ph3") { +"How it Works" }
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-ns pv2 ph3") { +"Pricing" }
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-l pv2 ph3") { +"About" }
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dn dib-l pv2 ph3") { +"Careers" }
                            a(href = "/", classes = "f6 fw4 hover-white no-underline white-70 dib ml2 pv2 ph3 ba") { +"Sign Up" }
                        }
                    }
                    // CALL TO ACTION
                    div(classes = "tc-l mt4 mt5-m mt6-l ph3") {
                        h1(classes = "f1 lh-title white-90 mb0") {
                            +"This is your super impressive headline"
                        }
                        h2(classes = "fw1 f3 white-80 mt3 mb4") {
                            +"Now a subheadline where explain your wonderful new startup even more"
                        }
                        a(href = "/", classes = "f6 no-underline grow dib v-mid bg-blue white ba b--blue ph3 pv2 mb3") {
                            +"Call to Action"
                        }
                        span(classes = "dib v-mid ph3 white-70 mb3") { +"or" }
                        a(href = "/", classes = "f6 no-underline grow dib v-mid white ba b--white ph3 pv2 mb3") { +"Secondary call to action" }
                    }
                }
            }
        }
        // CONTENT
        section(classes = "tc-l mt2 mt3-m mt3-l mw8 center ph3") {
            h1(classes = "f2 lh-copy white-90 mb0") {
                +"This is your super impressive headline"
            }
            h2(classes = "fw1 f3 white-80 mt3 mb4") {
                +"Now a subheadline where explain your wonderful new startup even more"
            }
            div(classes = "flex-m flex-l flex-wrap mt5") {
                article(classes = "mw8 center bg-white br3 pa3 pa4-ns mv3 ba b--black-10") {
                    div("tc") {
                        img(src = "http://tachyons.io/img/avatar_1.jpg", classes = "br-100 h3 w3 dib") {}
                        h1(classes = "f4 black") { +"UI/UX Design" }
                        hr(classes = "mw3 bb bw1 b--black-10") { }
                    }
                    p(classes = "lh-copy measure center f6 black-70") {
                        +"Quite affectionate and outgoing. She loves to get chin scratches and will roll around on the floor waiting for you give her more of them."
                    }
                }
                article(classes = "mw8 center bg-white br3 pa3 pa4-ns mv3 ba b--black-10") {
                    div("tc") {
                        img(src = "http://tachyons.io/img/avatar_1.jpg", classes = "br-100 h3 w3 dib") {}
                        h1(classes = "f4 black") { +"Branding Strategy" }
                        hr(classes = "mw3 bb bw1 b--black-10") { }
                    }
                    p(classes = "lh-copy measure center f6 black-70") {
                        +"Quite affectionate and outgoing. She loves to get chin scratches and will roll around on the floor waiting for you give her more of them."
                    }
                }
                article(classes = "mw8 center bg-white br3 pa3 pa4-ns mv3 ba b--black-10") {
                    div("tc") {
                        img(src = "http://tachyons.io/img/avatar_1.jpg", classes = "br-100 h3 w3 dib") {}
                        h1(classes = "f4 black") { +"Web Development" }
                        hr(classes = "mw3 bb bw1 b--black-10") { }
                    }
                    p(classes = "lh-copy measure center f6 black-70") {
                        +"Quite affectionate and outgoing. She loves to get chin scratches and will roll around on the floor waiting for you give her more of them."
                    }
                }
            }
        }

        // BANNER
        section(classes = "ph3 ph5-ns pv5") {
            article(classes = "mw8 center br2 ba b--light-blue bg-lightest-blue") {
                div(classes = "dt-ns dt--fixed-ns w-100") {
                    div(classes = "pa3 pa4-ns dtc-ns v-mid") {
                        div {
                            h2(classes = "fw4 blue mt0 mb3") { +"This is a promo title" }
                            p(classes = "black-70 measure lh-copy mv0") {
                                +"This is supporting copy for the wonderful promo catchphrase that is going to be used.\n"
                            }
                        }
                    }
                    div(classes = "pa3 pa4-ns dtc-ns v-mid") {
                        a(classes = "no-underline f6 tc db w-100 pv3 bg-animate bg-blue hover-bg-dark-blue white br2") {
                            +"Sign up for free"
                        }
                    }
                }
            }
        }

        // FOOTER
        footer(classes = "pv4 mt5 ph3 ph5-m ph6-l white bg-black") {
            small(classes = "f6 lh-copy db tc") {
                +"© 2021 "
                b(classes = "ttu") {
                    +"SOME COMPANY Inc"
                }
                +"., All Rights Reserved"
            }
            div(classes = "tc mt3") {
                a(href = "#", classes = "f6 dib ph2 link mid-gray dim") { +"Link1" }
                a(href = "#", classes = "f6 dib ph2 link mid-gray dim") { +"Link2" }
                a(href = "#", classes = "f6 dib ph2 link mid-gray dim") { +"Link3" }
            }
        }
    }
}
