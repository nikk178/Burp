HttpURLConnection httpUrlConnection = (HttpURLConnection)new URL("http://www.mypage.org/upload.php").openConnection();
        httpUrlConnection.setDoOutput(true);
        httpUrlConnection.setRequestMethod("POST");
        OutputStream os = httpUrlConnection.getOutputStream();
        Thread.sleep(1000);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream("tmpfile.tmp"));

        long totalByte = fis.available();
        long byteTrasferred = 0;
        for (int i = 0; i < totalByte; i++) {
            os.write(fis.read());
            byteTrasferred = i + 1;
        }

        os.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                httpUrlConnection.getInputStream()));

        String s = null;
        while ((s = in.readLine()) != null) {
            System.out.println(s);
        }
        in.close();
        fis.close();
        
