package com.example.Bankapplication.admin.service;
import java.util.List;
import com.example.Bankapplication.admin.dto.AdminRequest;
import com.example.Bankapplication.admin.entity.Admin;
import com.example.Bankapplication.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin addAdmin(AdminRequest request){

        Admin admin = new Admin();

        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        admin.setPhoneNumber(request.getPhoneNumber());
        admin.setRole(request.getRole());
        admin.setStatus(request.getStatus());

        return adminRepository.save(admin);

    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin updateAdmin(Long id, AdminRequest request) {

        Admin admin = adminRepository.findById(id).orElse(null);

        if (admin != null) {
            admin.setFirstName(request.getFirstName());
            admin.setLastName(request.getLastName());
            admin.setEmail(request.getEmail());
            admin.setPassword(request.getPassword());
            admin.setPhoneNumber(request.getPhoneNumber());
            admin.setRole(request.getRole());
            admin.setStatus(request.getStatus());

            return adminRepository.save(admin);
        }

        return null;
    }
    public String deleteAdmin(Long id) {

        adminRepository.deleteById(id);

        return "Admin deleted successfully";
    }
}