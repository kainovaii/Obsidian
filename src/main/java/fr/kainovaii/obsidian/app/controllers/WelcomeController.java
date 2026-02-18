package fr.kainovaii.obsidian.app.controllers;

import fr.kainovaii.obsidian.http.controller.BaseController;
import fr.kainovaii.obsidian.http.controller.annotations.Controller;
import fr.kainovaii.obsidian.routing.methods.GET;
import spark.Request;
import spark.Response;

import java.util.Map;

@Controller
public class WelcomeController extends BaseController
{
    @GET(value = "/", name = "site.home")
    private Object homepage(Request req, Response res)
    {
        return render("welcome.html", Map.of());
    }
}