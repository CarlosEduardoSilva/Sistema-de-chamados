package br.com.cobcondo.main.utils;

import java.io.Serializable;


public abstract class GenericService<T extends BaseEntity<ID>, ID extends Serializable >
implements ServiceMap{ }