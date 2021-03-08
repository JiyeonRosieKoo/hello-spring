package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //controller을 선언해줄 때 항상 필요!
public class HelloController {
    //정적 컨텐츠
    @GetMapping("hello")   //web사이트에서 "/hello"로 넘어가게되면 아래와 같은 함수가 불러와진다.
    public String hello(Model model) { //spring boot에서 model을 선언해준다.
        model.addAttribute("data", "Hello!!"); //html파일에서 data값을 "Hello"라고 출력해준다.
        return "hello"; //resources하단의 html파일 중 "hello.html" 파일을 찾아 return 해준다.
    }

    // MVC (model, view, controller) & template
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API
    @GetMapping("hello-string")
    @ResponseBody //http(통신 프로토콜의) 응답 body에 직접 넣어준다.
    public String HelloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-API")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
