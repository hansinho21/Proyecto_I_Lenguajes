package com.proyecto1.ecommerce.pdf.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.proyecto1.ecommerce.domain.Cliente;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePDFReport {

 public static ByteArrayInputStream PDFReport(List<Cliente> productos, String reporte) {

  Document document =  new Document(PageSize.LETTER , 36, 36, 54, 36);
  ByteArrayOutputStream out = new ByteArrayOutputStream();

  try {
   Image imagen = Image.getInstance("src/main/resources/static/img/JHJ-logo.png");
     Paragraph parrafo;
      parrafo = new Paragraph("Reporte de "+reporte+ " de la empresa JHJ");
     parrafo.setAlignment(Element.ALIGN_CENTER);
      
   PdfPTable table = new PdfPTable(3);
   table.setWidthPercentage(60);
   table.setWidths(new int[] { 1, 3, 3 });

   Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

   PdfPCell hcell;
   hcell = new PdfPCell(new Phrase("Id", headFont));
   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
   table.addCell(hcell);

   hcell = new PdfPCell(new Phrase("Name", headFont));
   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
   table.addCell(hcell);

   hcell = new PdfPCell(new Phrase("Population", headFont));
   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
   table.addCell(hcell);

   for (Cliente producto : productos) {

    PdfPCell cell;

    cell = new PdfPCell(new Phrase(producto.getNombre().toString()));
    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase(producto.getApellidos()));
    cell.setPaddingLeft(5);
    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase(producto.getCorreo()));
    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    cell.setPaddingRight(5);
    table.addCell(cell);
   }
//insertamos la informacion
   PdfWriter.getInstance(document, out);
   document.open();
   // posiconamos el logo
   document.add(parrafo);
   imagen.setAlignment(Element.ALIGN_LEFT);
   document.add(imagen);
   document.add(table);

   document.close();

  } catch (DocumentException | IOException ex) {

   Logger.getLogger(GeneratePDFReport.class.getName()).log(Level.SEVERE, null, ex);
  }

  return new ByteArrayInputStream(out.toByteArray());
 }
}