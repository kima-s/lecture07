package com.example.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {
    @GetMapping("/names")
    public List<String> getNames(@RequestParam("name") String name, @RequestParam("address") String address) {
        return List.of(name, address);
    }

    @PostMapping("/format")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated NameDateFormat form) {
        // 登録処理は省略
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();

        System.out.println(form.getName());
        return ResponseEntity.created(url).body(Map.of("name,dateOfBirth", "successfully created"));
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> updateName(@PathVariable("id") int id, @RequestBody NameUpdateForm nameUpdateForm) {
        // 更新処理は省略
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> deleteName(@PathVariable("id") int id) {
        // 更新処理は省略
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }
}




