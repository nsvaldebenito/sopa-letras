package org.sitrack.sopaletras.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.sitrack.sopaletras.dto.Letra;
import org.sitrack.sopaletras.dto.PosicionAletaoria;
import org.sitrack.sopaletras.dto.RequestFind;
import org.sitrack.sopaletras.dto.RequestSoup;
import org.sitrack.sopaletras.dto.Rows;
import org.sitrack.sopaletras.dto.Soup;
import org.sitrack.sopaletras.model.SoapEntityExtend;
import org.sitrack.sopaletras.model.SoupEntity;
import org.sitrack.sopaletras.repository.SoupRepository;
import org.sitrack.sopaletras.service.SopaLetrasService;
import org.sitrack.sopaletras.util.StringBuilderPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SopaLetrasServiceImpl implements SopaLetrasService {

	@Autowired
	SoupRepository soupRepository;

	public SoupEntity addSoup(RequestSoup requestSoup) throws Exception {
		
		if (requestSoup.getH() < 15 || requestSoup.getH() > 80)
			throw new Exception("Error en dimesion Alto de la Sopa de letras");  
		
		if (requestSoup.getW() < 15 || requestSoup.getW() > 80)
			throw new Exception("Error en dimesion Ancho de la Sopa de letras");    
		
		Soup soup = llenarSopa(requestSoup);
		SoapEntityExtend soupEntity = new SoapEntityExtend();
		soupEntity.setSoup(soup);

		try {
			SoupEntity soupEntity2 = soupRepository.save(soupEntity);
			return soupEntity2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String updateSoup(UUID soupId, RequestFind requestFind) throws ParseException {

		int sr = 0, sc = 0, er = 0, ec = 0;
		String message = "";
		String letra;
		String direccion = "";
		String palabra = "";
		int find = 0;
		Optional<SoapEntityExtend> soupEntityExtend = soupRepository.findById(soupId);

		if (soupEntityExtend.isPresent()) {
			SoapEntityExtend soupEntity = soupEntityExtend.get();

			int filas = soupEntity.getSoup().getPalabras().size();
			List<String> palabras = new ArrayList<String>();

			for (int i = 0; i < filas; i++) {

				sr = soupEntity.getSoup().getPalabras().get(i).getSr();
				sc = soupEntity.getSoup().getPalabras().get(i).getSc();
				er = soupEntity.getSoup().getPalabras().get(i).getEr();
				ec = soupEntity.getSoup().getPalabras().get(i).getEc();
				direccion = soupEntity.getSoup().getPalabras().get(i).getDireccion();
				palabra = soupEntity.getSoup().getPalabras().get(i).getPalabra();
				if (sr == requestFind.getSr() && sc == requestFind.getSc() && er == requestFind.getEr()
						&& ec == requestFind.getEc()) {
					soupEntity.getSoup().getPalabras().get(i).setEstado(1);
					message = ("palabra encontrada!");
					find = 1;
					break;
				}
			}

			if (find == 0)
				return "palabra no encontrada!";

			for (int k = 0; k < palabra.length(); k++) {
				letra = soupEntity.getSoup().getRows().get(sr - 1).getLetras().get(sc - 1).getLetra();
				soupEntity.getSoup().getRows().get(sr - 1).getLetras().get(sc - 1).setLetra(letra.toUpperCase());

				if (direccion.equals("l")) {
					sc = sc + 1;
				} else if (direccion.equals("r")) {
					sc = sc - 1;
				} else if (direccion.equals("b")) {
					sr = sr + 1;
				} else if (direccion.equals("t")) {
					sr = sr - 1;
				} else if (direccion.equals("d")) {
					sr = sr + 1;
					sc = sc + 1;
				}
			}

			SoupEntity soupEntity2 = soupRepository.save(soupEntity);
			return message;
		}
		return "Sopa de letras no encontrada";
	};

	public Soup llenarSopa(RequestSoup requestSoup) throws ParseException {
		String letras = "abcdefghijklmnopqrstuvwxyz";

		Random rnd = new Random();

		List<Rows> listRow = new ArrayList<Rows>();
		for (int i = 0; i < requestSoup.getH(); i++) {
			List<Letra> listLetra = new ArrayList<Letra>();
			for (int j = 0; j < requestSoup.getW(); j++) {
				Letra letra = new Letra();
				letra.setLetra(Character.toString(letras.charAt(rnd.nextInt(letras.length()))));
				listLetra.add(j, letra);
			}
			Rows row = new Rows();
			row.setLetras(listLetra);
			listRow.add(i, row);
		}
		Soup soup = new Soup();
		soup.setRows(listRow);

		List<String> palabras = addPalabras(requestSoup);
		List<String> direcciones = addDireccion(requestSoup);

		/*
		 * se establece una cantidad de palabras limite dependiendo de la dimension de
		 * la sopa de letras
		 */
		int cantidadPalabras = (requestSoup.getH() * requestSoup.getW()) / 10;
		if (palabras.size() < cantidadPalabras)
			cantidadPalabras = palabras.size();
		List<PosicionAletaoria> posicionAletaoriaList = new ArrayList<PosicionAletaoria>();
		for (int i = 0; i < cantidadPalabras; i++) {
			String palabra = palabraAletaoria(palabras);
			String direccion = direccionAletaoria(direcciones);
			PosicionAletaoria posicionAletaoria = new PosicionAletaoria();
			posicionAletaoria.setDireccion(direccion);
			posicionAletaoria.setLength(palabra.length());
			posicionAletaoria.setPalabra(palabra);
			PosicionAletaoria posicionAletaoria2 = posicionAletaoria(soup, posicionAletaoria);
			agregaletra(soup, posicionAletaoria2);
			posicionAletaoriaList.add(i, posicionAletaoria2);
		}
		soup.setPalabras(posicionAletaoriaList);

		return soup;

	}

	public String viewSoup(UUID soupId) {
		Optional<SoapEntityExtend> soupEntity = soupRepository.findById(soupId);
		String Soup;
		StringBuilderPlus sb = new StringBuilderPlus();

		int filas = soupEntity.get().getSoup().getRows().size();

		for (int i = 0; i < filas; i++) {
			String palabra = "|";
			int columnas = soupEntity.get().getSoup().getRows().get(i).getLetras().size();
			for (int j = 0; j < columnas; j++) {
				palabra = palabra + soupEntity.get().getSoup().getRows().get(i).getLetras().get(j).getLetra() + "|";
			}
			sb.appendLine(palabra);
		}
		return sb.toString();
	}

	public List<String> listSoup(UUID soupId) {
		Optional<SoapEntityExtend> soupEntity = soupRepository.findById(soupId);

		int filas = soupEntity.get().getSoup().getPalabras().size();
		List<String> palabras = new ArrayList<String>();

		for (int i = 0; i < filas; i++) {

			palabras.add(soupEntity.get().getSoup().getPalabras().get(i).getPalabra());
		}

		return palabras;
	}

	public String palabraAletaoria(List<String> palabras) throws ParseException {
		Random rnd = new Random();
		int indice = rnd.nextInt(palabras.size());
		String palabra = palabras.get(indice);
		palabras.remove(indice);
		return palabra;
	}

	public String direccionAletaoria(List<String> direccionList) throws ParseException {
		Random rnd = new Random();
		return direccionList.get(rnd.nextInt(direccionList.size()));

	}

	public PosicionAletaoria posicionAletaoria(Soup soup, PosicionAletaoria posicionAletaoria) throws ParseException {
		Random rnd = new Random();
		int letra = 0;
		int len = posicionAletaoria.getLength();
		String direccion = posicionAletaoria.getDireccion();
		int sizeRow = soup.getRows().size() - 1;
		boolean valida = true;
		while (valida) {
			letra = 0;
			int x = rnd.nextInt(soup.getRows().size() - 1);
			int sizeLetras = soup.getRows().get(x).getLetras().size() - 1;
			int y = rnd.nextInt(soup.getRows().get(x).getLetras().size() - 1);
			int sr = x;
			int sc = y;
			int er = 0;
			int ec = 0;
			for (int n = 0; n < len; n++) {
				if (x <= sizeRow && y <= sizeLetras) {
					int estado = soup.getRows().get(x).getLetras().get(y).getEstado();
					er = x;
					ec = y;
					if (estado == 0) {
						if (direccion.equals("l")) {
							y = y + 1;
						} else if (direccion.equals("r")) {
							y = y - 1;
						} else if (direccion.equals("b")) {
							x = x + 1;
						} else if (direccion.equals("t")) {
							x = x - 1;
						} else if (direccion.equals("d")) {
							x = x + 1;
							y = y + 1;
						}
						letra++;
					} else
						break;
				} else
					break;
			}
			if (letra == len) {
				valida = false;
				posicionAletaoria.setSr(sr + 1);
				posicionAletaoria.setSc(sc + 1);
				posicionAletaoria.setEr(er + 1);
				posicionAletaoria.setEc(ec + 1);
			}
		}
		return posicionAletaoria;
	}

	public void agregaletra(Soup soup, PosicionAletaoria posicionAletaoria) throws ParseException {
		int len = posicionAletaoria.getLength();
		String direccion = posicionAletaoria.getDireccion();
		int x = posicionAletaoria.getSr();
		int y = posicionAletaoria.getSc();
		String palabra = posicionAletaoria.getPalabra();

		for (int n = 0; n < len; n++) {
			char c = palabra.charAt(n);
			soup.getRows().get(x - 1).getLetras().get(y - 1).setEstado(1);
			soup.getRows().get(x - 1).getLetras().get(y - 1).setLetra(Character.toString(c));

			if (direccion.equals("l")) {
				y = y + 1;
			} else if (direccion.equals("r")) {
				y = y - 1;
			} else if (direccion.equals("b")) {
				x = x + 1;
			} else if (direccion.equals("t")) {
				x = x - 1;
			} else if (direccion.equals("d")) {
				x = x + 1;
				y = y + 1;
			}
		}

	}

	public List<String> addPalabras(RequestSoup requestSoup) throws ParseException {
		List<String> palabras = new ArrayList<String>();
		palabras.add(0, "aguila");
		palabras.add(1, "avestruz");
		palabras.add(2, "cebra");
		palabras.add(3, "chimpance");
		palabras.add(4, "elefante");
		palabras.add(5, "jirafa");
		palabras.add(6, "leon");
		palabras.add(7, "lobo");
		palabras.add(8, "nutria");
		palabras.add(9, "tigre");
		return palabras;
	}

	public List<String> addDireccion(RequestSoup requestSoup) throws ParseException {

		List<String> direccion = new ArrayList<String>();

		if (requestSoup.isLtr())
			direccion.add("l");
		if (requestSoup.isRtl())
			direccion.add("r");
		if (requestSoup.isTtb())
			direccion.add("b");
		if (requestSoup.isBtt())
			direccion.add("t");
		if (requestSoup.isD())
			direccion.add("d");

		return direccion;
	}

}
