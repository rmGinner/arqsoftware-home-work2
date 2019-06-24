package br.rmginner.dao.authentication.impl;

import br.rmginner.dao.AbstractDao;
import br.rmginner.dao.auctioning.AuctionDao;
import br.rmginner.dao.authentication.AuthenticationDao;
import br.rmginner.dto.authentication.AuthenticationDto;
import br.rmginner.enums.AuctionStatus;
import br.rmginner.model.auctioning.Auction;
import br.rmginner.model.auctioning.AuctionItem;
import br.rmginner.model.auctioning.Auctioneer;
import br.rmginner.model.authentication.Authentication;
import br.rmginner.model.authentication.AuthorizationRoles;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthenticationDaoImpl extends AbstractDao implements AuthenticationDao {

    @Override
    public AuthorizationRoles authenticate(Authentication authentication) {
        AuthorizationRoles authorizationRoles = null;

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT 1 FROM authentication WHERE cpf = ? AND password = ?")) {
                ps.setString(1, authentication.getCpf());
                ps.setString(2, authentication.getPassword());

                try (var rs = ps.executeQuery()) {
                    if(rs.next()){
                        try(var ps2 = conn.prepareStatement("SELECT name FROM role WHERE id in(SELECT role_id FROM authentication_role WHERE cpf = ?)")){
                            ps2.setString(1,authentication.getCpf());

                            try(var rs2 = ps2.executeQuery()){
                                authorizationRoles = new AuthorizationRoles();
                                while(rs2.next()){
                                    if(rs2.getString(1).equals("administrator")){
                                        authorizationRoles.setAdmin(true);
                                    }else if(rs2.getString(1).equals("auctioneer")){
                                        authorizationRoles.setAuctioneer(true);
                                    }else if(rs2.getString(1).equals("bidder")){
                                        authorizationRoles.setBidder(true);
                                    }
                                }

                                return authorizationRoles;
                            }catch (SQLException e){
                                e.printStackTrace();
                            }
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
