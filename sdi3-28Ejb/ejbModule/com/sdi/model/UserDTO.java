package com.sdi.model;

import java.io.Serializable;

import com.sdi.model.types.UserStatus;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String login;
	private String email;
	private Boolean isAdmin = false;
	private UserStatus status = UserStatus.ENABLED;

	private int tareasCompletadas;
	private int tareasCompletadasRetrasadas;
	private int tareasPlanificadas;
	private int tareasSinPlanificar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public int getTareasCompletadas() {
		return tareasCompletadas;
	}

	public void setTareasCompletadas(int tareasCompletadas) {
		this.tareasCompletadas = tareasCompletadas;
	}

	public int getTareasCompletadasRetrasadas() {
		return tareasCompletadasRetrasadas;
	}

	public void setTareasCompletadasRetrasadas(int tareasCompletadasRetrasadas) {
		this.tareasCompletadasRetrasadas = tareasCompletadasRetrasadas;
	}

	public int getTareasPlanificadas() {
		return tareasPlanificadas;
	}

	public void setTareasPlanificadas(int tareasPlanificadas) {
		this.tareasPlanificadas = tareasPlanificadas;
	}

	public int getTareasSinPlanificar() {
		return tareasSinPlanificar;
	}

	public void setTareasSinPlanificar(int tareasSinPlanificar) {
		this.tareasSinPlanificar = tareasSinPlanificar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
