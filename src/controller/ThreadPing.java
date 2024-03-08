package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadPing extends Thread {
	
	private int site;

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public ThreadPing(int site) {
		this.site = site;
	}
	
	public void run() {
		String os = os();
		if (os.contains("Windows")) {
			System.err.println("SISTEMA OPERACIONAL INVALIDO");
		}else {
			switch (site) {
				case 0:
					google();
					break;
				case 1: 
					uol();
					break;
				case 2: 
					terra();
					break;
				default:
					break;
			}
		}
	}
	
	public void google() {
		String google = "ping -4 -c 10 www.google.com.br";
		try {
			Process pGoogle = Runtime.getRuntime().exec(google);
			InputStream fluxoGoogle = pGoogle.getInputStream();
			InputStreamReader leitorGoogle = new InputStreamReader(fluxoGoogle);
			BufferedReader bufferGoogle = new BufferedReader(leitorGoogle);
			String linhaGoogle = bufferGoogle.readLine();
			while (linhaGoogle != null) {
				if (linhaGoogle.contains("avg")) {
					String[] pingGoogle = linhaGoogle.split("/");
					System.out.println("A media de ms do Google eh de: " + pingGoogle[4]);
				}
				linhaGoogle = bufferGoogle.readLine();
			}
		} catch (IOException e) {
		}
	}
	
	public void uol() {
		String uol = "ping -4 -c 10 www.uol.com.br";
		try {
			Process pUOL = Runtime.getRuntime().exec(uol);
			InputStream fluxoUOL = pUOL.getInputStream();
			InputStreamReader leitorUOL = new InputStreamReader(fluxoUOL);
			BufferedReader bufferUOL = new BufferedReader(leitorUOL);
			String linhaUOL = bufferUOL.readLine();
			while (linhaUOL != null) {
				if (linhaUOL.contains("avg")) {
					String[] pingUOL = linhaUOL.split("/");
					System.out.println("A media de ms do UOL eh de: " + pingUOL[4]);
				}
				linhaUOL = bufferUOL.readLine();
			}
		} catch (IOException e) {
		}
	}
	
	public void terra() {
		String terra = "ping -4 -c 10 www.terra.com.br";
		try {
			Process pTerra = Runtime.getRuntime().exec(terra);
			InputStream fluxoTerra = pTerra.getInputStream();
			InputStreamReader leitorTerra = new InputStreamReader(fluxoTerra);
			BufferedReader bufferTerra = new BufferedReader(leitorTerra);
			String linhaTerra = bufferTerra.readLine();
			while (linhaTerra != null) {
				if (linhaTerra.contains("avg")) {
					String[] pingTerra = linhaTerra.split("/");
					System.out.println("A media de ms do Terra eh de: " + pingTerra[4]);
				}
				linhaTerra = bufferTerra.readLine();
			}
		} catch (IOException e) {
		}
	}

}
