package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.repository.EstudianteRepositorio;

@Service
public class EstudiantesServicioImpl implements EstudianteServicio {

	@Autowired
	private EstudianteRepositorio repositorio;

	@Override
	public List<Estudiante> listarTodosLosEstudiantes() {
		return repositorio.findAll();// primer metodo de servicio
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudianteId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante eliminarEstudiante(Long id) {
		repositorio.deleteById(id);
		return null;
	}

}
