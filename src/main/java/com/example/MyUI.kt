package com.example

import com.vaadin.annotations.Theme
import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.VaadinRequest
import com.vaadin.server.VaadinServlet
import com.vaadin.ui.*
import javax.servlet.annotation.WebServlet

@Theme("mytheme")
class MyUI : UI() {

    override fun init(vaadinRequest: VaadinRequest) {
        val layout = VerticalLayout()

        val name = TextField()
        name.caption = "Type your name here:"

        val button = Button("Click Me")
        button.addClickListener { e ->
            layout.addComponent(Label("Thanks " + name.value
                    + ", it works!"))
        }

        layout.addComponents(name, button)

        content = layout
    }

    @WebServlet(urlPatterns = arrayOf("/*"), name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI::class, productionMode = false)
    class MyUIServlet : VaadinServlet()
}
