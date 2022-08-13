package com.osama.projectmanger.controllers;

import com.osama.projectmanger.models.LoginUser;
import com.osama.projectmanger.models.Project;
import com.osama.projectmanger.models.Task;
import com.osama.projectmanger.models.User;
import com.osama.projectmanger.repositories.UserRepository;
import com.osama.projectmanger.services.ProjectService;
import com.osama.projectmanger.services.TaskService;
import com.osama.projectmanger.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userServ;
    @Autowired
    private ProjectService projectServ;

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
            return "forms.jsp";
        } else {
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            session.removeAttribute("user_id");
            // session.invalidate();//destroy all
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "forms.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "forms.jsp";
        }

        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String welcome(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            User user = userServ.findUser((Long) session.getAttribute("user_id"));
            model.addAttribute("User", user);
            List<Project> yourProjectsJoin = projectServ.allProjectsContain(user);
            List<Project> notJoinprojects = projectServ.allProjectsNotContain(user);
            List<Project> yourProjects = projectServ.allProjectsByUser(user);// leader
            yourProjects.addAll(yourProjectsJoin);

            // model.addAttribute("Num", yourProjects);
            model.addAttribute("projects", notJoinprojects);
            model.addAttribute("yourProjects", yourProjects);
            return "index.jsp";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/project/add") // add
    public String create(@Valid @ModelAttribute("Project") Project project, BindingResult result, Model model,
                         HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            if (result.hasErrors()) {
                return "add.jsp";
            } else {
                User user = userServ.findUser((Long) session.getAttribute("user_id"));
                project.setUser(user);
                projectServ.createProject(project);
                return "redirect:/dashboard";
            }
        } else {
            return "redirect:/";
        }

    }

    @GetMapping("/project/new") // add form
    public String New(@ModelAttribute("Project") Project project, BindingResult result, Model model,
                      HttpSession session) {
        if (session.getAttribute("user_id") != null) {

            return "add.jsp";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/project/{id}/edit") // edit form
    public String edit(@PathVariable("id") Long id, @ModelAttribute("Project") Project projectinfo,
                       BindingResult result,
                       Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Project project = projectServ.findProject(id);
            model.addAttribute("id", id);
            model.addAttribute("Project", project);
            return "edit.jsp";
        } else {
            return "redirect:/";
        }
    }

    @PutMapping("/project/{id}/edit") // update
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("Project") Project projectinfo,
                         BindingResult result, HttpSession session, Model model) {
        if (session.getAttribute("user_id") != null) {
            if (result.hasErrors()) {
                model.addAttribute("id", id);
                return "edit.jsp";
            } else {
                projectServ.updateProject(projectinfo, id);
                return "redirect:/dashboard";
            }
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/project/{id}/joinin") // join team
    public String Borrow(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Project project = projectServ.findProject(id);
            User user = userServ.findUser((Long) session.getAttribute("user_id"));
            projectServ.JoinProject(project, id, user);
            return "redirect:/dashboard";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/project/{id}/outjoin") // leave team
    public String UnBorrow(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Project project = projectServ.findProject(id);
            User user = userServ.findUser((Long) session.getAttribute("user_id"));
            projectServ.OutJoinProject(project, id, user);
            return "redirect:/dashboard";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/project/{id}") // details page
    public String details(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Project project = projectServ.findProject(id);
            model.addAttribute("Project", project);
            User user = userServ.findUser((Long) session.getAttribute("user_id"));
            model.addAttribute("User", user);
            return "details.jsp";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/project/{id}/tasks") // tasks page
    public String Tasks(@PathVariable("id") Long id, @ModelAttribute("Task") Task task,
                        BindingResult result, Model model, HttpSession session) {
        User user = userServ.findUser((Long) session.getAttribute("user_id"));

        if (session.getAttribute("user_id") != null) {
            Project project = projectServ.findProject(id);
            model.addAttribute("Project", project);
            model.addAttribute("id", id);
            List<Task> listTask = taskService.allTasks();
            model.addAttribute("Tasks", listTask);

            return "tasks.jsp";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/project/{id}/tasks") // add tasks
    public String addTasks(@PathVariable("id") Long id, @Valid @ModelAttribute("Task") Task task,
                           BindingResult result, Model model, HttpSession session) {
        Project project = projectServ.findProject(id);
        User user = userServ.findUser((Long) session.getAttribute("user_id"));
        if (session.getAttribute("user_id") != null) {
            if (result.hasErrors()) {

                model.addAttribute("Project", project);
                model.addAttribute("id", id);
                List<Task> listTask = taskService.allTasks();
                model.addAttribute("Tasks", listTask);
                return "tasks.jsp";
            } else {
                taskService.createTask(task, user, project);
                return "redirect:/project/" + id + "/tasks";
            }
        } else {
            return "redirect:/";
        }
    }

    @DeleteMapping("/Project/{id}") // del
    public String destroy(@PathVariable("id") Long id) {
        projectServ.deleteProject(id);
        return "redirect:/dashboard";
    }

}
