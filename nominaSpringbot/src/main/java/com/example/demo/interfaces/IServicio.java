package com.example.demo.interfaces;

import java.util.List;

public interface IServicio<T,ID> {

	public T findById(ID id);

	public List<T> findAll();

	public void save(T t);

	public void deleteById(ID id);
}
