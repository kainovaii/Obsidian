package fr.kainovaii.spark.app.controllers;

import fr.kainovaii.core.web.route.methods.GET;
import fr.kainovaii.core.web.controller.BaseController;
import fr.kainovaii.core.web.controller.Controller;
import spark.Request;
import spark.Response;

import java.util.Map;

@Controller
public class HomeController extends BaseController
{
    @GET(value = "/", name = "site_home")
    private Object homepage(Request req, Response res)
    {
        return render("landing/home.html", Map.of());
    }
}