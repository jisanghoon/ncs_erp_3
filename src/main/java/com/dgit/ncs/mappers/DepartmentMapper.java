package com.dgit.ncs.mappers;

import java.util.List;

public interface DepartmentMapper<T> {
	void insert(T item);

	void delete(int idx);

	void update(T item);

	List<T> selectAll();

	T selectByNo(int idx);

}
