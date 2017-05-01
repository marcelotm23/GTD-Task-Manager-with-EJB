package com.sdi.business.impl.task.command;

import alb.util.date.DateUtil;

import com.sdi.business.exception.BusinessCheck;
import com.sdi.business.exception.BusinessException;
import com.sdi.business.impl.command.Command;
import com.sdi.model.Task;
import com.sdi.persistence.Persistence;
import com.sdi.persistence.TaskDao;

public class MarkTaskAsFinishedCommand implements Command<Void> {

	private Long id;
	private Long idUser;

	public MarkTaskAsFinishedCommand(Long id) {
		this.id = id;
	}

	public MarkTaskAsFinishedCommand(Long idTarea, Long idUser) {
		this.id = idTarea;
		this.idUser = idUser;
	}

	@Override
	public Void execute() throws BusinessException {
		TaskDao tDao = Persistence.getTaskDao();
		
		Task t = tDao.findById(id);
		BusinessCheck.isNotNull(t, "The task does not exist");
		if(idUser != null) {
			BusinessCheck.isOwn(t, idUser, "The task is not yours");
		}
		
		t.setFinished( DateUtil.today() );
		tDao.update( t );
		return null;
	}

}
