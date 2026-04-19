select a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
from patient p join (select * from appointment where APNT_CNCL_YN = 'N' and date_format(apnt_ymd, '%Y-%m-%d') = '2022-04-13' ) a on p.pt_no = a.pt_no
    join (select * from doctor where mcdp_cd = 'CS') d on a.mddr_id = d.dr_id
order by a.apnt_ymd