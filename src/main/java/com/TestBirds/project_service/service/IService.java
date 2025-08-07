package com.TestBirds.project_service.service;

import java.util.List;

public interface IService<T>  {
     T save (T gen);
     public T getOne(int id);
     public T updateOne(T obj);
     public List<T> findAll(String userName);
     public void deleteOne(T obj);

}
