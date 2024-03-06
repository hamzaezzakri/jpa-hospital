package net.ezzakri.hospital;

import net.ezzakri.hospital.Repositories.*;
import net.ezzakri.hospital.enteties.*;
import net.ezzakri.hospital.service.IHospitalService;
import net.ezzakri.hospital.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner run(IHospitalService hospitalService,
						  PatientRepository patientRepository,
						  MedecinRepository medecinRepository,
						  UserService userService){
		return args -> {
			Stream.of("Mohamed", "Hassan", "Najat").forEach(name->{
				hospitalService.savePatient(Patient.builder().nom(name).dateNaissance(new Date()).malade(false).build());
			});

			Stream.of("aymane", "hanane", "yasmine").forEach(name->{
				hospitalService.saveMedecin(Medecin.builder().nom(name).specialite(Math.random()>0.5?"Cardio":"Dentiste").email(name+"@gmail.com").build());
			});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("Mohamed");

			Medecin medecin = medecinRepository.findByNom("yasmine");

			RendezVous rendezVous = hospitalService.saveRendezVous(RendezVous.builder().date(new Date()).status(StatusRDV.PENDING).medecin(medecin).patient(patient).build());

			hospitalService.saveConsultation(Consultation.builder().dateConsultation(new Date()).rendezVous(rendezVous).rapport("Rapposrt de la consultation...").build());

			User user =  userService.addNewUser(User.builder().username("user1").password("123456").build());
			userService.addNewUser(User.builder().username("admin").password("123456").build());

			Stream.of("STUDENT", "USER", "ADMIN").forEach(role->{
				userService.addNewRole(Role.builder().roleName(role).build());
			});

			userService.addRoleToUser("user1", "STUDENT");
			userService.addRoleToUser("user1", "USER");
			userService.addRoleToUser("admin", "USER");
			userService.addRoleToUser("admin", "ADMIN");
		};
	}
}
