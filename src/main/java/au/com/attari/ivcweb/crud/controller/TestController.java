package au.com.attari.ivcweb.crud.controller;

import au.com.attari.ivcweb.crud.view.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    @PreAuthorize("hasRole('user') or hasRole('moderator') or hasRole('admin')")
    public ResponseEntity<?> allAccess() {
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Public Content."));
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<?> userAccess() {
        return ResponseEntity
                .ok()
                .body(new MessageResponse("User Content."));
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('moderator')")
    public ResponseEntity<?> moderatorAccess() {
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Moderator Content."));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?>  adminAccess() {
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Admin Content."));
    }

    @GetMapping("/basic/service")
    @PreAuthorize("hasRole('service')")
    public ResponseEntity<?> service() {
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Service Account Content."));
    }
}
