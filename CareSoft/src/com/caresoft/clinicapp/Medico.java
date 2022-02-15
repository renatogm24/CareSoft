package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Medico extends Usuario implements UsuarioCompatibleConHIPAA {
	// Dentro de la clase:
	private ArrayList<String> patientNotes;

	// PARA HACER: Constructor que tome un ID
	public Medico(Integer id) {
		super(id);
	}

	// PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == getId()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin > 999 && pin <= 9999) {
			setPin(pin);
			return true;
		} else {
			return false;
		}

	}

	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Fecha y hora de envío: %s \n", date);
		report += String.format("Reportado por ID: %s\n", this.id);
		report += String.format("Nombre del paciente: %s\n", patientName);
		report += String.format("Notas: %s \n", notes);
		this.patientNotes.add(report);
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	// PARA HACER: Setters y Getters
	
}
