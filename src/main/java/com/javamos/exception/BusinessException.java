package com.javamos.exception;

public  class BusinessException extends RuntimeException {
	public static String ERROR_ID = "400";
	private String tipo;
	private String codigo;
	private String mensagem;
	
	
	public BusinessException(Erro erro, Object ... params) {
		this(erro.getCodigo(),erro.getMensagem(),params);
	}
	
	public BusinessException(String codigo, String msg, Object ... params) {
		this(ERROR_ID,codigo,msg,params);
	}
	
	public BusinessException(String tipo, String codigo, String msg, Object ... params) {
		super(String.format(msg,params));
		this.tipo = tipo;
		this.codigo = codigo;
		this.mensagem = String.format(msg,params);
	}
	public BusinessException(String mensagem) {
		this("400","999",mensagem);
	}
	public String getTipo() {
		return tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public static void main(String[] args) {
		BusinessException b = new BusinessException("Ola");
		
		try {
			throw new BusinessException("olasdasd");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		try {
			throw new BusinessException("2","2", "Jรก existe um email %s", "email@email");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		
	}
}