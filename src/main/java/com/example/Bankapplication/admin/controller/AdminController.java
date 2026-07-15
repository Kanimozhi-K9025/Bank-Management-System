package com.example.Bankapplication.admin.controller;
import java.util.List;
import com.example.Bankapplication.admin.dto.AdminRequest;
import com.example.Bankapplication.admin.entity.Admin;
import com.example.Bankapplication.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping()
    public Admin addAdmin(@RequestBody AdminRequest request) {
        return adminService.addAdmin(request);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id,
                             @RequestBody AdminRequest request) {

        return adminService.updateAdmin(id, request);
    }
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {

        return adminService.deleteAdmin(id);
    }
}