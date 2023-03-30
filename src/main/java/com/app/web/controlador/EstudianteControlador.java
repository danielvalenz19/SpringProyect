package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {
	@Autowired
	private EstudianteServicio servicio;

	@GetMapping({ "/estudiantes", "/" })
	public String listarEstudiantes(Model model) {
		model.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
		return "estudiantes";
	}

	@GetMapping("/estudiantes/nuevo")
	public String mostrarFromularioDeRegistrarEstudiante(Model model) {
		Estudiante estudiante = new Estudiante();
		model.addAttribute("estudiante", estudiante);
		return "crearEstudiante";
	}

	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
		model.addAttribute("estudiante", servicio.obtenerEstudianteId(id));
		return "editarEstudiantes";
	}

	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model model) {
		Estudiante estudiateExistente = servicio.obtenerEstudianteId(id);
		estudiateExistente.setId(id);
		estudiateExistente.setNombre(estudiante.getNombre());
		estudiateExistente.setApellido(estudiante.getApellido());
		estudiateExistente.setEmail(estudiante.getEmail());
		servicio.actualizarEstudiante(estudiateExistente);
		return "redirect:/estudiantes";
	}

	@GetMapping("estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}

}
