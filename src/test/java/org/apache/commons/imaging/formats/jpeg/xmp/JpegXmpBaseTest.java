/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.imaging.formats.jpeg.xmp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.SanselanTest;
import org.apache.commons.imaging.common.bytesource.ByteSource;
import org.apache.commons.imaging.common.bytesource.ByteSourceFile;
import org.apache.commons.imaging.formats.jpeg.JpegImageParser;

public abstract class JpegXmpBaseTest extends SanselanTest
{

    protected static boolean hasJpegXmpData(File file)
    {
        if (!file.getName().toLowerCase().endsWith(".jpg"))
            return false;
        //ImageFormat format = Sanselan.guessFormat(file);
        //if (format != ImageFormat.IMAGE_FORMAT_JPEG)
        //    return false;

        //        Debug.debug("possible file", file);

        try
        {
            ByteSource byteSource = new ByteSourceFile(file);
            return new JpegImageParser().hasXmpSegment(byteSource);
        }
        catch (Exception e)
        {
            //            Debug.debug("Error file", file.getAbsoluteFile());
            //            Debug.debug(e, 4);
            return false;
        }
    }

    private static final ImageFilter HAS_JPEG_XMP_IMAGE_FILTER = file -> hasJpegXmpData(file);

    protected File getImageWithXmpData() throws IOException,
            ImageReadException
    {
        return getTestImage(HAS_JPEG_XMP_IMAGE_FILTER);
    }

    protected List getImagesWithXmpData() throws IOException,
            ImageReadException
    {
        return getTestImages(HAS_JPEG_XMP_IMAGE_FILTER);
    }

    protected List getImagesWithXmpData(int max) throws IOException,
            ImageReadException
    {
        return getTestImages(HAS_JPEG_XMP_IMAGE_FILTER, max);
    }

//    protected File getJpegImage() throws IOException, ImageReadException
//    {
//        return getTestImage(JPEG_IMAGE_FILTER);
//    }
//
//    protected List getJpegImages() throws IOException, ImageReadException
//    {
//        return getTestImages(JPEG_IMAGE_FILTER);
//    }
//
//    protected List getJpegImages(int max) throws IOException,
//            ImageReadException
//    {
//        return getTestImages(JPEG_IMAGE_FILTER, max);
//    }

}
