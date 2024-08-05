package com.soter.dogp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

@Controller
public class DogDrawController {
    @GetMapping("/draw")
    public String drawLoader(){
        return "dogDraw";
    }

    @PostMapping("/uploadCanvas")
    public String uploadCanvas(@RequestBody CanvasData canvasData, HttpSession session) {
        //manda essa desgraça pro service.
        try {
            // Suco do chatgpteison esse metodo aqui
            String base64Image = canvasData.getImageData().split(",")[1];
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            Integer userid = (Integer) session.getAttribute("USERID");
            String path = "C:/Users/Pichau/Pictures/picdogs/" + userid.toString()+ ".png";
            File file = new File(path);

            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))){
                outputStream.write(imageBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro subindo o diabo do canva");
        }
        return "dogDraw.html";
    }
    static class CanvasData {
        private String imageData;

        public String getImageData() {
            return imageData;
        }

        public void setImageData(String imageData) {
            this.imageData = imageData;
        }
    }
}
