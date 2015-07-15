package com.zkread.dao.interfaces;

import java.util.List;

public interface ICommonDAO<E> {
	public long 	save		(E newObj);
	public int 		del			(E delObj);
	public int 		update		(E updateObj);
	public E 		getById		(E theObj);
	public List<E> 	getByParam	(E paramObj);
}
