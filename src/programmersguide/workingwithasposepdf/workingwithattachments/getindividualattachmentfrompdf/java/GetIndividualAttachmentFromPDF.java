/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithattachments.getindividualattachmentfrompdf.java;

import com.aspose.pdf.*;

import java.io.IOException;
import java.io.InputStream;

public class GetIndividualAttachmentFromPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithattachments/getindividualattachmentfrompdf/data/";

        //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

            //get particular embedded file
            FileSpecification fileSpecification = pdfDocument.getEmbeddedFiles().get_Item(1);

            //get the file properties
            System.out.printf("Name: - " + fileSpecification.getName());
            System.out.printf("\nDescription: - " + fileSpecification.getDescription());
            System.out.printf("\nMime Type: - " + fileSpecification.getMIMEType());

            // get attachment form PDF file
            try {

                InputStream input = fileSpecification.getContents();

                // create and extract file from pdf
                java.io.FileOutputStream output = new java.io.FileOutputStream(dataDir +"test.txt", true);

                byte[] buffer = new byte[4096];
                int n = 0;
                while (-1 != (n = input.read(buffer)))
                    output.write(buffer, 0, n);

                // close InputStream object
                input.close();

                output.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        // close Document object
        pdfDocument.dispose();
    }
}




