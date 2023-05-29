package com.example.pazaSautiDb.Controller;

import com.example.pazaSautiDb.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "api/videos")
public class StreamingController {

    @Autowired
    public ImageService imageService;
    @PostMapping(value ="upload")
    public ResponseEntity uploadImage(@RequestParam MultipartFile file){
        return this.imageService.uploadToLocalFileSystem(file);
    }
    @GetMapping(
            value = "getVideo/{videoName:.+}",
            produces = "video/mp4"
    )
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "videoName") String fileName) throws IOException {
        return this.imageService.getImageWithMediaType(fileName);
    }
}
